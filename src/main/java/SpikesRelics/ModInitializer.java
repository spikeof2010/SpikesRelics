package SpikesRelics;

import SpikesRelics.cards.blue.DiskWipe;
import SpikesRelics.cards.colorless.*;
import SpikesRelics.cards.curses.*;
import SpikesRelics.cards.green.InfectiousVector;
import SpikesRelics.cards.red.Absolvement;
import SpikesRelics.cards.red.BarbarianYell;
import SpikesRelics.cards.red.Invigoration;
import SpikesRelics.events.thebottom.impshop;
import basemod.interfaces.*;
import com.evacipated.cardcrawl.mod.stslib.Keyword;
import com.evacipated.cardcrawl.mod.stslib.StSLib;
import basemod.BaseMod;
import basemod.helpers.RelicType;
import SpikesRelics.cards.blue.RefreshScreen;
import SpikesRelics.cards.green.Pace;
import SpikesRelics.cards.green.ShadowRift;
import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.mod.stslib.StSLib;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.Exordium;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.EventStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import SpikesRelics.relics.*;


import java.nio.charset.StandardCharsets;

@SpireInitializer
public class ModInitializer implements EditRelicsSubscriber, PostInitializeSubscriber, EditCardsSubscriber, EditStringsSubscriber, EditKeywordsSubscriber {

    public ModInitializer() {
        //Use this for when you subscribe to any hooks offered by BaseMod.
        BaseMod.subscribe(this);
    }

    //Used by @SpireInitializer
    public static void initialize() {

        //This creates an instance of our classes and gets our code going after BaseMod and ModTheSpire initialize.
        ModInitializer modInitializer = new ModInitializer();

        //Look at the BaseMod wiki for getting started. (Skip the decompiling part. It's not needed right now)

    }


    public void receiveEditCards() {
        BaseMod.addCard(new SharpHide());
        BaseMod.addCard(new Degenerate());
        BaseMod.addCard(new Assess());
        BaseMod.addCard(new Feint());
        BaseMod.addCard(new Reforge());
        BaseMod.addCard(new Intolerance());
        BaseMod.addCard(new Notoriety());
        BaseMod.addCard(new Hatred());
        BaseMod.addCard(new CloudedMind());
        BaseMod.addCard(new BlessedFruit());
        BaseMod.addCard(new TheSerpent());
        BaseMod.addCard(new Roar());
        BaseMod.addCard(new BarbarianYell());
        BaseMod.addCard(new Absolvement());
        BaseMod.addCard(new RefreshScreen());
        BaseMod.addCard(new Invigoration());
        BaseMod.addCard(new Pace());
        BaseMod.addCard(new InfectiousVector());
        BaseMod.addCard(new DiskWipe());
        BaseMod.addCard(new ShadowRift());
        BaseMod.addCard(new PlatinumSkin());

    }

    public void receiveEditRelics() {
        BaseMod.addRelic(new ToyHorsey(), RelicType.SHARED);
        BaseMod.addRelic(new SuspiciousGoo(), RelicType.SHARED);
        BaseMod.addRelic(new DaevaFist(), RelicType.SHARED);
        BaseMod.addRelic(new GolemAmulet(), RelicType.RED);
        BaseMod.addRelic(new CrustySpines(), RelicType.SHARED);
        BaseMod.addRelic(new Sandwich(), RelicType.SHARED);
        BaseMod.addRelic(new RollingBoulder(), RelicType.SHARED);
        BaseMod.addRelic(new WizardHat(), RelicType.SHARED);
        BaseMod.addRelic(new BlackRope(), RelicType.SHARED);
        BaseMod.addRelic(new ShockBauble(), RelicType.SHARED);
        BaseMod.addRelic(new CherryCoatedStake(), RelicType.SHARED);
        BaseMod.addRelic(new HyperAlloy(), RelicType.BLUE);
     //   BaseMod.addRelic(new GloomPolyp(), RelicType.GREEN);
        BaseMod.addRelic(new SnailShell(), RelicType.SHARED);
        BaseMod.addRelic(new ZombieTooth(), RelicType.SHARED);
        BaseMod.addRelic(new BicycleWheel(), RelicType.SHARED);
        BaseMod.addRelic(new ExplosiveVial(), RelicType.SHARED);
        BaseMod.addRelic(new MiniBlackHole(), RelicType.SHARED);
        BaseMod.addRelic(new CosmicIsotope(), RelicType.SHARED);
        BaseMod.addRelic(new Rawhide(), RelicType.SHARED);
        BaseMod.addRelic(new GiantMaggot(), RelicType.SHARED);
        BaseMod.addRelic(new BrokenLever(), RelicType.SHARED);
        BaseMod.addRelic(new RetroEgg(), RelicType.SHARED);
        BaseMod.addRelic(new RoseTintedShades(), RelicType.SHARED);
        BaseMod.addRelic(new LugNut(), RelicType.SHARED);
        BaseMod.addRelic(new SneckoPlush(), RelicType.SHARED);
        BaseMod.addRelic(new HeavenlyBonsai(), RelicType.SHARED);
        BaseMod.addRelic(new ToxicTincture(), RelicType.GREEN);
        BaseMod.addRelic(new HailfireSword(), RelicType.RED);
        RelicLibrary.addBlue(new AncientExoskeleton());
    }
    public void receiveEditKeywords() {
        final Gson gson = new Gson();
        final String json = Gdx.files.internal("localization/examplekeywords.json").readString(String.valueOf(StandardCharsets.UTF_8));
        final Keyword[] keywords = (Keyword[])gson.fromJson(json, (Class) Keyword[].class);
        if (keywords != null) {
            for (final Keyword keyword : keywords) {
                BaseMod.addKeyword(keyword.NAMES, keyword.DESCRIPTION);
            }
        }
    }
    @Override
    public void receiveEditStrings() {
        String relicStrings = Gdx.files.internal("localization/example-relics.json").readString(
                String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
        String powerStrings = Gdx.files.internal("localization/powerstrings.json").readString(
                String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(PowerStrings.class, powerStrings);
        String cardStrings = Gdx.files.internal("localization/cardstrings.json").readString(
                String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(CardStrings.class, cardStrings);
        String eventStrings = Gdx.files.internal("localization/spikesevents.json").readString(
                String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(EventStrings.class, eventStrings);
    }

    @Override
    public void receivePostInitialize() {

    }

    //@Override
    // public void receivePostInitialize() {
    //    BaseMod.addEvent(impshop.ID, impshop.class, Exordium.ID);
    //}
}
