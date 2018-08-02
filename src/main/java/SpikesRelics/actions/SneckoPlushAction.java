package SpikesRelics.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class SneckoPlushAction extends AbstractGameAction {
    public SneckoPlushAction() {
        this.duration = Settings.ACTION_DUR_XFAST;
    }

    public void update() {
        AbstractCard c = AbstractDungeon.player.hand.getRandomCard(true);
        if ((c.cost > -1) && (c.color != AbstractCard.CardColor.CURSE) && (c.type != AbstractCard.CardType.STATUS))
        {
            int newCost = AbstractDungeon.cardRandomRng.random(3);
            if (c.cost != newCost)
            {
                c.costForTurn = newCost;
                c.isCostModified = true;
            }
        }

        this.isDone = true;
    }
}
