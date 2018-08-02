package SpikesRelics.relics;

import SpikesRelics.actions.SneckoPlushAction;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class SneckoPlush extends CustomRelic {
    public static final String ID = "SpikesRelics:SneckoPlush";
    private static final String IMG = "images/relics/SneckoPlush.png";
    private static final String OUTLINE = "images/relics/outline/SneckoPlush.png";

    private static final int BLOCK_AMT = 10;
    private static final int STR_AMT = 2;

    public SneckoPlush() {
        super(ID, new Texture(Gdx.files.internal(IMG)), new Texture(Gdx.files.internal(OUTLINE)), RelicTier.SHOP, LandingSound.HEAVY);
    }

    public void atTurnStartPostDraw() {
        AbstractDungeon.actionManager.addToBottom(new SneckoPlushAction());
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1] + DESCRIPTIONS[2];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new SneckoPlush();
    }
}