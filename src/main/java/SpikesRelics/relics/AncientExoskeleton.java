package SpikesRelics.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.defect.IncreaseMaxOrbAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.Frost;
import com.megacrit.cardcrawl.powers.*;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class AncientExoskeleton extends CustomRelic {
    public static final String ID = "AncientExoskeleton";
    private static final String IMG = "images/relics/AncientExoskeleton.png";
    private static final String OUTLINE = "images/relics/outline/AncientExoskeleton.png";

    public AncientExoskeleton() {
        super(ID, new Texture(Gdx.files.internal(IMG)), new Texture(Gdx.files.internal(OUTLINE)), RelicTier.BOSS, LandingSound.HEAVY);
    }

    public void atPreBattle() {
        AbstractDungeon.player.channelOrb(new Frost());
    }

    @Override
    public void atBattleStart() {
        flash();
        AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new FocusPower(AbstractDungeon.player,1), 1));
        AbstractDungeon.actionManager.addToBottom(new IncreaseMaxOrbAction(2));
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, 11));
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1] + DESCRIPTIONS[2];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new AncientExoskeleton();
    }
}