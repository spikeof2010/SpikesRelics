package SpikesRelics.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class RoseTintedShades extends CustomRelic {
    public static final String ID = "RoseTintedShades";
    private static final String IMG = "images/relics/RoseTintedShades.png";
    private static final String OUTLINE = "images/relics/outline/RoseTintedShades.png";

    public RoseTintedShades() {
        super(ID, new Texture(Gdx.files.internal(IMG)), new Texture(Gdx.files.internal(OUTLINE)), RelicTier.UNCOMMON, LandingSound.CLINK);
    }

    public void onObtainCard(AbstractCard c) {
        c.magicNumber ++;
        c.baseDamage ++;
        c.baseBlock ++;
    }


    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1] + DESCRIPTIONS[2];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new RoseTintedShades();
    }


}