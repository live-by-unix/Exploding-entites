package com.dimexhits;

import java.util.Map;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class DimensionalExplosiveHits implements ModInitializer {

    private static final Map<RegistryKey<World>, Float> EXPLOSION_POWER_BY_DIMENSION = Map.of(
            World.OVERWORLD, 3.0f,
            World.NETHER, 6.0f,
            World.END, 7.0f);

    @Override
    public void onInitialize() {
        AttackEntityCallback.EVENT.register(DimensionalExplosiveHits::onAttackEntity);
    }

    private static ActionResult onAttackEntity(
            PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) {
        if (world.isClient() || player.isSpectator()) {
            return ActionResult.PASS;
        }
        if (!(entity instanceof LivingEntity living)) {
            return ActionResult.PASS;
        }
        Float power = EXPLOSION_POWER_BY_DIMENSION.get(world.getRegistryKey());
        if (power == null) {
            return ActionResult.PASS;
        }
        world.createExplosion(
                player,
                world.getDamageSources().explosion(player, player),
                null,
                living.getX(),
                living.getY(),
                living.getZ(),
                power,
                false,
                World.ExplosionSourceType.MOB);
        return ActionResult.PASS;
    }
}
