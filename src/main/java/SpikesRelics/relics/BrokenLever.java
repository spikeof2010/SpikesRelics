package SpikesRelics.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.PoisonPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.Iterator;

public class BrokenLever extends CustomRelic {
    public static final String ID = "BrokenLever";
    private static final String IMG = "images/relics/BrokenLever.png";
    private static final String OUTLINE = "images/relics/outline/BrokenLever.png";

    private static final int NUM_TURNS = 15;

    public BrokenLever() {
        super(ID, new Texture(Gdx.files.internal(IMG)), new Texture(Gdx.files.internal(OUTLINE)), RelicTier.UNCOMMON, LandingSound.HEAVY);

    }
    private static boolean SKILL = false;
    private static boolean POWER = false;
    private static boolean ATTACK = false;

    @Override
    public void atBattleStart() {
        SKILL = false;
        POWER = false;
        ATTACK = false;
    }
    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.type == AbstractCard.CardType.ATTACK) {
            ATTACK = true;
        } else if (card.type == AbstractCard.CardType.SKILL) {
            SKILL = true;
        } else if (card.type == AbstractCard.CardType.POWER) {
            POWER = true;
        }

        if (ATTACK && SKILL && POWER) {
            this.flash();
            AbstractPlayer p = AbstractDungeon.player;
            for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
                AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new StrengthPower(m, -2), -2));
            }
            SKILL = false;
            POWER = false;
            ATTACK = false;
        }

    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1] + DESCRIPTIONS[2];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new BrokenLever();
    }
}