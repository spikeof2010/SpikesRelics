package SpikesRelics.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.colorless.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
@SpirePatch(cls="com.megacrit.cardcrawl.cards.colorless.Shiv", method = "use")
public class CheckShivPatch {
    public static void Postfix(Shiv obj, AbstractPlayer p, AbstractMonster m) {
        if (AbstractDungeon.player.hasRelic("ToxicTincture")) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new PoisonPower(m, p, 2), 2));
        }
    }
}