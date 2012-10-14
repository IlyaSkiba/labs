<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <link rel="stylesheet" type="text/css" href="styles.css"/>
            </head>
            <body>
                <div class="container">
                    <div class="header">
                        <div class="selection">
                            Select
                        </div>
                        <div class="column">
                            Name
                        </div>
                        <div class="column">
                            Address
                        </div>
                        <div class="column">
                            Phone
                        </div>
                    </div>
                    <xsl:apply-templates select="clients"/>
                    <div class="buttons">
                        <div style="display:inline-block">
                            <form action="list?Direction=FIRST">
                                <input type="hidden" name="Direction" value="FIRST"/>
                                <button type="submit">First</button>
                            </form>
                        </div>
                        <div style="display:inline-block">
                            <form action="list">
                                <input type="hidden" name="Direction" value="PREV"/>
                                <button type="submit">Previous</button>
                            </form>
                        </div>
                        <div style="display:inline-block">
                            <form action="list">
                                <input type="hidden" name="Direction" value="NEXT"/>
                                <button type="submit">Next</button>
                            </form>
                        </div>
                        <div style="display:inline-block">
                            <form action="list">
                                <input type="hidden" name="Direction" value="LAST"/>
                                <button type="submit">Last</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="links">
                    <a href="register/add.jsp">Add</a>
                    <br/>
                    <a href="delete">Delete</a>
                </div>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="clients">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="client">
        <div class="row">
            <div class="selection">
                <input type="checkbox"/>
            </div>
            <xsl:apply-templates/>
        </div>
    </xsl:template>

    <xsl:template match="name|address|phone">
        <div class="column">
            <xsl:value-of select="."/>
        </div>
    </xsl:template>

</xsl:stylesheet>