package relics;

import basemod.abstracts.CustomRelic;
import cards.colorless.BlessedFruit;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;

public class HeavenlyBonsai extends CustomRelic {
    public static final String ID = "HeavenlyBonsai";
    private static final String IMG = "images/relics/HeavenlyBonsai.png";
    private static final String OUTLINE = "images/relics/outline/HeavenlyBonsai.png";

    private static final int BLOCK_AMT = 10;
    private static final int STR_AMT = 2;

    public HeavenlyBonsai() {
        super(ID, new Texture(Gdx.files.internal(IMG)), new Texture(Gdx.files.internal(OUTLINE)), RelicTier.RARE, LandingSound.HEAVY);
    }

    public void onEquip() {
        AbstractDungeon.effectList.add(new ShowCardAndObtainEffect(new BlessedFruit(), (float)(Settings.WIDTH / 3), (float)(Settings.HEIGHT / 2)));
        AbstractDungeon.effectList.add(new ShowCardAndObtainEffect(new BlessedFruit(), (float)(Settings.WIDTH * 2/3), (float)(Settings.HEIGHT / 2)));
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1] + DESCRIPTIONS[2];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new HeavenlyBonsai();
    }
}