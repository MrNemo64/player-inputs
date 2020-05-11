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

package io.github.nemo_64.chatinput.bukkit;

import io.github.nemo_64.chatinput.ChatInputBuilder;
import io.github.nemo_64.chatinput.PlayerChatInput;
import io.github.nemo_64.chatinput.bukkit.impl.BkktPlugin;
import io.github.nemo_64.chatinput.bukkit.impl.BkktSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

/**
 * Builder for the {@link PlayerChatInput} class
 *
 * @param <T> The {@link PlayerChatInput} type
 * @author Nemo_64
 */
public final class BukkitChatInputBuilder<T> extends ChatInputBuilder<T, Player, BkktSender, BukkitTask, Listener> {

    /**
     * @param plugin The main class of the plugin
     * @param player The player that will send the input
     */
    public BukkitChatInputBuilder(@NotNull final Plugin plugin, @NotNull final Player player) {
        super(new BkktPlugin(plugin), new BkktSender(player));
    }

    @NotNull
    public static <T> BukkitChatInputBuilder<T> builder(@NotNull final Plugin plugin, @NotNull final Player player) {
        return new BukkitChatInputBuilder<>(plugin, player);
    }

    @NotNull
    public static BukkitChatInputBuilder<Integer> integer(@NotNull final Plugin plugin, @NotNull final Player player) {
        return new BukkitChatInputBuilder<>(plugin, player);
    }

    /**
     * Creates the {@link PlayerChatInput}
     *
     * @return A new {@link PlayerChatInput}
     */
    @NotNull
    @Override
    public BukkitChatInput<T> build() {
        return new BukkitChatInput<>(this.plugin, this.sender, this.value, this.invalidInputMessage,
            this.sendValueMessage, this.isValidInput, this.setValue, this.onFinish, this.onCancel, this.cancel,
            this.onInvalidInput, this.repeat, this.onExpire, this.expire);
    }

}