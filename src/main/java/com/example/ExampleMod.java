package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.util.ActionResult;
import net.minecraft.text.Text;
 import net.minecraft.util.math.BlockPos;

public class ExampleMod implements ModInitializer {
    @Override
    public void onInitialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockPos pos = hitResult.getBlockPos();
            String blockName = world.getBlockState(pos).getBlock().getTranslationKey().toLowerCase();

            if (blockName.contains("crate") || blockName.contains("chest")) {
                 if (!world.isClient) 
                    player.sendMessage(Text.literal("§6[Mod] §aBypassing Crate Key..."), true);
                }
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        });
    }
