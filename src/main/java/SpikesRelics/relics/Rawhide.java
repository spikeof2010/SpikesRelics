package SpikesRelics.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class Rawhide extends CustomRelic {
    public static final String ID = "Rawhide";
    private static final String IMG = "images/relics/Rawhide.png";
    private static final String OUTLINE = "images/relics/outline/Rawhide.png";

    public Rawhide() {
        super(ID, new Texture(Gdx.files.internal(IMG)), new Texture(Gdx.files.internal(OUTLINE)), RelicTier.UNCOMMON, LandingSound.HEAVY);
    }
    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        if (info.owner != null && info.type != DamageInfo.DamageType.HP_LOSS && info.type != DamageInfo.DamageType.THORNS && damageAmount > 1) {
            this.flash();
            AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            return damageAmount - 2;
        } else {
            return damageAmount;
        }
    }
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1] + DESCRIPTIONS[2];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new Rawhide();
    }
}