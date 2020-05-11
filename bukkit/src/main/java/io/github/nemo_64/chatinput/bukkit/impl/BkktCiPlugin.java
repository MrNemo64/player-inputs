/*
 * MIT License
 *
 * Copyright (c) 2020 MrNemo64
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.nemo_64.chatinput.bukkit.impl;

import io.github.nemo_64.chatinput.CiPlugin;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public final class BkktCiPlugin implements CiPlugin<BukkitTask, Listener> {

    @NotNull
    private final org.bukkit.plugin.Plugin plugin;

    public BkktCiPlugin(@NotNull final org.bukkit.plugin.Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void registerEvent(@NotNull final Listener event) {
        this.plugin.getServer().getPluginManager().registerEvents(event, this.plugin);
    }

    @Override
    public BukkitTask createRunTaskLater(@NotNull final Runnable runnable, final long time) {
        return this.plugin.getServer().getScheduler().runTaskLater(this.plugin, runnable, time);
    }

}
