package relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.ThornsPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class Sandwich extends CustomRelic {
    public static final String ID = "Sandwich";
    private static final String IMG = "images/relics/Sandwich.png";
    private static final String OUTLINE = "images/relics/outline/Sandwich.png";

    public Sandwich() {
        super(ID, new Texture(Gdx.files.internal(IMG)), new Texture(Gdx.files.internal(OUTLINE)), RelicTier.BOSS, LandingSound.HEAVY);
    }

        @Override
        public void atTurnStart() {
            flash();
            AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, 1));
            AbstractCard c = AbstractDungeon.returnTrulyRandomCard(AbstractDungeon.cardRandomRng).makeCopy();
            c.setCostForTurn(0);
            AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(c, true));
}

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1] + DESCRIPTIONS[2];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new Sandwich();
    }
}