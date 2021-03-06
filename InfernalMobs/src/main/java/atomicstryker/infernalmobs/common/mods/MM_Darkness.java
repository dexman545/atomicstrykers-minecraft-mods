package atomicstryker.infernalmobs.common.mods;

import atomicstryker.infernalmobs.common.InfernalMobsCore;
import atomicstryker.infernalmobs.common.MobModifier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;

public class MM_Darkness extends MobModifier {

    private static String[] suffix = {"ofDarkness", "theShadow", "theEclipse"};
    private static String[] prefix = {"dark", "shadowkin", "eclipsed"};

    public MM_Darkness() {
        super();
    }

    public MM_Darkness(MobModifier next) {
        super(next);
    }

    @Override
    public String getModName() {
        return "Darkness";
    }

    @Override
    public float onHurt(LivingEntity mob, DamageSource source, float damage) {
        if (source.getTrueSource() != null
                && (source.getTrueSource() instanceof LivingEntity)
                && InfernalMobsCore.instance().getIsEntityAllowedTarget(source.getTrueSource())) {
            ((LivingEntity) source.getTrueSource()).addPotionEffect(new EffectInstance(Effects.BLINDNESS, 120, 0));
        }

        return super.onHurt(mob, source, damage);
    }

    @Override
    public float onAttack(LivingEntity entity, DamageSource source, float damage) {
        if (entity != null
                && InfernalMobsCore.instance().getIsEntityAllowedTarget(entity)) {
            entity.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 120, 0));
        }

        return super.onAttack(entity, source, damage);
    }

    @Override
    protected String[] getModNameSuffix() {
        return suffix;
    }

    @Override
    protected String[] getModNamePrefix() {
        return prefix;
    }

}
