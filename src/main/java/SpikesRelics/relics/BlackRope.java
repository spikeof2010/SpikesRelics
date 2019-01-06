package SpikesRelics.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.MonsterRoomBoss;
import com.megacrit.cardcrawl.rooms.MonsterRoomElite;

public class BlackRope extends CustomRelic {
    public static final String ID = "BlackRope";
    private static final String IMG = "images/relics/BlackRope.png";
    private static final String OUTLINE = "images/relics/outline/BlackRope.png";

    private static final int NUM_TURNS = 5;

    public BlackRope() {
        super(ID, new Texture(Gdx.files.internal(IMG)), new Texture(Gdx.files.internal(OUTLINE)), RelicTier.RARE, LandingSound.HEAVY);
    }

    public void onEquip() {
        this.counter = 1;
    }

    public void atBattleStart() {
        for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
            AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(m, this));
            m.addPower(new StrengthPower(m, -this.counter));
            m.addPower(new GainStrengthPower(m, this.counter));
        }
    }

    @Override
    public void onVictory()
    {
        if (AbstractDungeon.getCurrRoom() instanceof MonsterRoomElite
                || AbstractDungeon.getCurrRoom() instanceof MonsterRoomBoss) {
            flash();
            setCounter(counter + 2);
        }
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1] + DESCRIPTIONS[2];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new BlackRope();
    }
}