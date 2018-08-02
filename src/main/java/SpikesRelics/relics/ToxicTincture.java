package SpikesRelics.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class ToxicTincture extends CustomRelic {
    public static final String ID = "ToxicTincture";
    private static final String IMG = "images/relics/ToxicTincture.png";
    private static final String OUTLINE = "images/relics/outline/ToxicTincture.png";

    public ToxicTincture() {
        super(ID, new Texture(Gdx.files.internal(IMG)), new Texture(Gdx.files.internal(OUTLINE)), RelicTier.SHOP, LandingSound.HEAVY);
    }


    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1] + DESCRIPTIONS[2];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new ToxicTincture();
    }
}