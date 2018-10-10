package com.github.shynixn.astraledit.core.business.extension

import com.github.shynixn.astraledit.api.business.service.ConcurrencyService

/**
 * Created by Shynixn 2018.
 * <p>
 * Version 1.2
 * <p>
 * MIT License
 * <p>
 * Copyright (c) 2018 by Shynixn
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
/**
 * Executes the given [f] via the [concurrencyService] synchronized with the server tick.
 */
inline fun Any.sync(concurrencyService: ConcurrencyService, delayTicks: Long = 0L, repeatingTicks: Long = 0L, crossinline f: () -> Unit) {
    concurrencyService.runTaskSync(delayTicks, repeatingTicks, Runnable { f.invoke() })
}

/**
 * Executes the given [f] via the [concurrencyService] asynchronous.
 */
inline fun Any.async(concurrencyService: ConcurrencyService, delayTicks: Long = 0L, repeatingTicks: Long = 0L, crossinline f: () -> Unit) {
    concurrencyService.runTaskAsync(delayTicks, repeatingTicks, Runnable { f.invoke() })
}