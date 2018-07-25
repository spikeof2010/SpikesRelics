import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostDrawSubscriber;
import cards.colorless.*;
import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import relics.*;

import java.nio.charset.StandardCharsets;

@SpireInitializer
public class ModInitializer implements PostDrawSubscriber, EditRelicsSubscriber, EditCardsSubscriber, EditStringsSubscriber {

    public ModInitializer(){
        //Use this for when you subscribe to any hooks offered by BaseMod.
        BaseMod.subscribeToEditRelics(this);
        BaseMod.subscribe(this);
    }

    //Used by @SpireInitializer
    public static void initialize(){

        //This creates an instance of our classes and gets our code going after BaseMod and ModTheSpire initialize.
        ModInitializer modInitializer = new ModInitializer();

        //Look at the BaseMod wiki for getting started. (Skip the decompiling part. It's not needed right now)

    }

    @Override
    public void receivePostDraw(AbstractCard card) {
        System.out.println(card.name + " was drawn!=======================================");
    }

    public void receiveEditCards()  {
        BaseMod.addCard(new SharpHide());
        BaseMod.addCard(new Degenerate());
        BaseMod.addCard(new Assess());
        BaseMod.addCard(new Feint());
        BaseMod.addCard(new Reforge());

    }
    public void receiveEditRelics() {
        BaseMod.addRelic(new ToyHorse(), RelicType.SHARED);
        BaseMod.addRelic(new DaevaFist(), RelicType.SHARED);
        BaseMod.addRelic(new CrustySpines(), RelicType.SHARED);
        BaseMod.addRelic(new Sandwich(), RelicType.SHARED);
        BaseMod.addRelic(new RollingBoulder(), RelicType.SHARED);
        BaseMod.addRelic(new WizardHat(), RelicType.SHARED);
        BaseMod.addRelic(new GloomPolyp(), RelicType.GREEN);
        BaseMod.addRelic(new SnailShell(), RelicType.SHARED);
        BaseMod.addRelic(new ExplosiveVial(), RelicType.SHARED);
        BaseMod.addRelic(new MiniBlackHole(), RelicType.SHARED);
        BaseMod.addRelic(new CosmicIsotope(), RelicType.SHARED);
        RelicLibrary.addBlue(new AncientExoskeleton());
    }
    @Override
    public void receiveEditStrings() {
        String relicStrings = Gdx.files.internal("localization/example-relics.json").readString(
                String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
        String powerStrings = Gdx.files.internal("localization/example-relics.json").readString(
                String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(PowerStrings.class, powerStrings);
        String cardStrings = Gdx.files.internal("localization/cardstrings.json").readString(
                String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(CardStrings.class, cardStrings);
    }
}
