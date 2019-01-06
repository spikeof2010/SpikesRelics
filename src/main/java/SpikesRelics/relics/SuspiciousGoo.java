package SpikesRelics.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.MonsterRoomBoss;
import com.megacrit.cardcrawl.rooms.MonsterRoomElite;

public class SuspiciousGoo extends CustomRelic {
    public static final String ID = "SuspiciousGoo";
    private static final String IMG = "images/relics/SuspiciousGoo.png";
    private static final String OUTLINE = "images/relics/outline/SuspiciousGoo.png";

    private static final int NUM_TURNS = 5;

    public SuspiciousGoo() {
        super(ID, new Texture(Gdx.files.internal(IMG)), new Texture(Gdx.files.internal(OUTLINE)), RelicTier.RARE, LandingSound.HEAVY);
    }

    public void onEquip() {
        this.counter = 2;
    }

    public void atBattleStart() {
        this.counter = 2;
    }

    public void atTurnStart() {
        if (this.counter < 0) {
            this.counter = 0;
        } else {
            --this.counter;
        }
    }

    @Override
    public void onVictory()
    {
        if (this.counter > 0) {
            flash();
            AbstractDungeon.player.increaseMaxHp(3, true);
        }
        this.counter = 2;
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1] + DESCRIPTIONS[2];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new SuspiciousGoo();
    }
}