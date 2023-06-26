<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="players-page" page-height="11in" page-width="8.5in" margin-top="1cm" margin-bottom="1cm" margin-left="1cm" margin-right="1cm">
                    <fo:region-body margin-top="2cm" margin-bottom="2cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="players-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="14pt" font-family="Arial" text-align="center" space-after="12pt">
                        <fo:table table-layout="fixed" width="100%" border="1pt solid black">
                            <fo:table-column column-width="2cm"/>
                            <fo:table-column column-width="3cm"/>
                            <fo:table-column column-width="5cm"/>
                            <fo:table-column column-width="3cm"/>
                            <fo:table-column column-width="2cm"/>
                            <fo:table-column column-width="3cm"/>
                            <fo:table-column column-width="2cm"/>
                            <fo:table-header>
                                <fo:table-row>
                                    <fo:table-cell><fo:block>ID</fo:block></fo:table-cell>
                                    <fo:table-cell><fo:block>Name</fo:block></fo:table-cell>
                                    <fo:table-cell><fo:block>Email</fo:block></fo:table-cell>
                                    <fo:table-cell><fo:block>Password</fo:block></fo:table-cell>
                                    <fo:table-cell><fo:block>Age</fo:block></fo:table-cell>
                                    <fo:table-cell><fo:block>Balance</fo:block></fo:table-cell>
                                    <fo:table-cell><fo:block>Credits</fo:block></fo:table-cell>
                                </fo:table-row>
                            </fo:table-header>
                            <fo:table-body>
                                <xsl:apply-templates select="//player"/>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

    <xsl:template match="player">
        <fo:table-row>
            <fo:table-cell><fo:block><xsl:value-of select="id"/></fo:block></fo:table-cell>
            <fo:table-cell><fo:block><xsl:value-of select="name"/></fo:block></fo:table-cell>
            <fo:table-cell><fo:block><xsl:value-of select="account/email"/></fo:block></fo:table-cell>
            <fo:table-cell><fo:block><xsl:value-of select="account/password"/></fo:block></fo:table-cell>
            <fo:table-cell><fo:block><xsl:value-of select="account/age"/></fo:block></fo:table-cell>
            <fo:table-cell><fo:block><xsl:value-of select="account/balance"/></fo:block></fo:table-cell>
            <fo:table-cell><fo:block><xsl:value-of select="account/credits"/></fo:block></fo:table-cell>
        </fo:table-row>
        <fo:table-row>
            <fo:table-cell number-columns-spanned="6">
                <fo:block font-weight="bold" font-size="12pt">Transactions:</fo:block>
                <fo:table>
                    <fo:table-column column-width="4cm"/>
                    <fo:table-column column-width="3cm"/>
                    <fo:table-header>
                        <fo:table-row>
                            <fo:table-cell><fo:block>Type</fo:block></fo:table-cell>
                            <fo:table-cell><fo:block>Amount</fo:block></fo:table-cell>
                        </fo:table-row>
                    </fo:table-header>
                    <fo:table-body>
                        <xsl:apply-templates select="account/transactions/transaction"/>
                    </fo:table-body>
                </fo:table>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>

    <xsl:template match="transaction">
        <fo:table-row>
            <fo:table-cell><fo:block><xsl:value-of select="transactionType"/></fo:block></fo:table-cell>
            <fo:table-cell><fo:block><xsl:value-of select="amount"/></fo:block></fo:table-cell>
        </fo:table-row>
    </xsl:template>

</xsl:stylesheet>