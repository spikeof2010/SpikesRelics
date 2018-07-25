package relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;


import java.util.Iterator;

public class CosmicIsotope extends CustomRelic {
    public static final String ID = "CosmicIsotope";
    private static final String IMG = "images/relics/CosmicIsotope.png";
    private static final String OUTLINE = "images/relics/outline/CosmicIsotope.png";
    public static final int STR = 2;

    public CosmicIsotope() {
        super(ID, new Texture(Gdx.files.internal(IMG)), new Texture(Gdx.files.internal(OUTLINE)), RelicTier.BOSS, LandingSound.HEAVY);
    }
    

    public String getUpdatedDescription() {
        return AbstractDungeon.player != null ? this.setDescription(AbstractDungeon.player.chosenClass) : this.setDescription((AbstractPlayer.PlayerClass)null);
    }

    private String setDescription(AbstractPlayer.PlayerClass c) {
        if (c == null) {
            return this.DESCRIPTIONS[1] + this.DESCRIPTIONS[0];
        } else {
            switch(c) {
                case IRONCLAD:
                    return this.DESCRIPTIONS[1] + this.DESCRIPTIONS[0];
                case THE_SILENT:
                    return this.DESCRIPTIONS[2] + this.DESCRIPTIONS[0];
                case DEFECT:
                    return this.DESCRIPTIONS[3] + this.DESCRIPTIONS[0];
                default:
                    return this.DESCRIPTIONS[1] + this.DESCRIPTIONS[0];
            }
        }
    }

    public void updateDescription(AbstractPlayer.PlayerClass c) {
        this.description = this.setDescription(c);
        this.tips.clear();
        this.tips.add(new PowerTip(this.name, this.description));
        this.initializeTips();
    }
    public void atBattleStart() {
        for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
            AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(m, this));
            m.addPower(new PlatedArmorPower(m, 5));
            m.addPower(new ArtifactPower(m, 1));
        }
    }
        public void onEquip() {
        ++AbstractDungeon.player.energy.energyMaster;
    }

    public void onUnequip() {
        --AbstractDungeon.player.energy.energyMaster;
    }

    @Override
    public AbstractRelic makeCopy() {
        return new CosmicIsotope();
    }
}