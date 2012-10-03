<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>CD Collection</h2>
                <table>
                    <tr>
                        <td>
                            Title
                        </td>
                        <td>
                            Artist
                        </td>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="cd">
        <p>
            <tr>
                <xsl:apply-templates select="title"/>
                <xsl:apply-templates select="artist"/>
            </tr>
        </p>
    </xsl:template>

    <xsl:template match="title">
        <td>

            <span style="color:#ff0000">
                <xsl:value-of select="."/>
            </span>
            <br/>
        </td>
    </xsl:template>

    <xsl:template match="artist">
        <td>

            <span style="color:#00ff00">
                <xsl:value-of select="."/>
            </span>
            <br/>
        </td>
    </xsl:template>

</xsl:stylesheet>