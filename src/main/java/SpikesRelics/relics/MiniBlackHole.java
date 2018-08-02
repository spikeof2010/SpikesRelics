package SpikesRelics.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.SlowPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class MiniBlackHole extends CustomRelic {
    public static final String ID = "MiniBlackHole";
    private static final String IMG = "images/relics/MiniBlackHole.png";
    private static final String OUTLINE = "images/relics/outline/MiniBlackHole.png";

    private static final int NUM_TURNS = 5;

    public MiniBlackHole() {
        super(ID, new Texture(Gdx.files.internal(IMG)), new Texture(Gdx.files.internal(OUTLINE)), RelicTier.COMMON, LandingSound.HEAVY);
    }
    public void atBattleStart() {
        this.counter = 0;
    }
    public void onEquip() {
        this.counter = 0;
    }

    public void atTurnStart() {
        if (this.counter == -1) {
            this.counter += 2;
        } else {
            ++this.counter;
        }

        if (this.counter == 5) {
            this.counter = 0;
            this.flash();
            AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
                AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(m, this));
                AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, AbstractDungeon.player, new SlowPower(m, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
            }
        }
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1] + DESCRIPTIONS[2];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new MiniBlackHole();
    }
}