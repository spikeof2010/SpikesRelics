    package SpikesRelics.cards.colorless;

    import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
    import com.megacrit.cardcrawl.cards.AbstractCard;
    import com.megacrit.cardcrawl.characters.AbstractPlayer;
    import com.megacrit.cardcrawl.core.CardCrawlGame;
    import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
    import com.megacrit.cardcrawl.localization.CardStrings;
    import com.megacrit.cardcrawl.monsters.AbstractMonster;
    import com.megacrit.cardcrawl.powers.ThornsPower;

    public class SharpHide
            extends AbstractCard
    {
        public static final String ID = "Sharp Hide";
        private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Sharp Hide");
        public static String NAME = cardStrings.NAME;
        public static String DESCRIPTION = cardStrings.DESCRIPTION;
        public static String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

        public SharpHide()
        {
            super("Sharp Hide", NAME, "status/beta", "status/beta", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCard.CardColor.COLORLESS, AbstractCard.CardRarity.UNCOMMON, CardTarget.SELF);
            this.exhaust = true;
            this.baseMagicNumber = 2;
            this.magicNumber = this.baseMagicNumber;
        }

        public void use(AbstractPlayer p, AbstractMonster m) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new ThornsPower(p, this.magicNumber), this.magicNumber));
        }

        public AbstractCard makeCopy()
        {
            return new SharpHide();
        }

        public void upgrade() {
            if (!this.upgraded) {
                this.upgradeName();
                this.exhaust = false;
                this.rawDescription = UPGRADE_DESCRIPTION;
                this.initializeDescription();
            }

        }
        static {
            cardStrings = CardCrawlGame.languagePack.getCardStrings("Sharp Hide");
            NAME = cardStrings.NAME;
            DESCRIPTION = cardStrings.DESCRIPTION;
        }
    }