package SpikesRelics.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class ToyHorsey extends CustomRelic {
    public static final String ID = "SpikesRelics:ToyHorsey";
    private static final String IMG = "images/relics/ToyHorsey.png";
    private static final String OUTLINE = "images/relics/outline/ToyHorsey.png";

    private static final int BLOCK_AMT = 10;
    private static final int STR_AMT = 2;

    public ToyHorsey() {
        super(ID, new Texture(Gdx.files.internal(IMG)), new Texture(Gdx.files.internal(OUTLINE)), RelicTier.UNCOMMON, LandingSound.HEAVY);
    }

    @Override
    public void atTurnStart() {
        if (AbstractDungeon.player.currentHealth <= (AbstractDungeon.player.maxHealth / 2)) {
            flash();
            AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new StrengthPower(AbstractDungeon.player, STR_AMT), STR_AMT));
        }
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1] + DESCRIPTIONS[2];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new ToyHorsey();
    }
}