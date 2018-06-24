/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package test.javafx.scene.web;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MathMLRenderTest extends TestBase {

    @Test public void testTokenHeight() throws Exception {

        // Document test
        String mathmlContent
            = "<math display=\"block\">"
            + "   <mrow>"
            + "      <mi>x</mi>"
            + "      <mo>=</mo>"
            + "      <mfrac>"
            + "         <mrow>"
            + "            <mo>−</mo>"
            + "            <mi>b</mi>"
            + "            <mo>±</mo>"
            + "            <msqrt>"
            + "               <mrow>"
            + "                  <msup>"
            + "                     <mi>b</mi>"
            + "                     <mn>2</mn>"
            + "                  </msup>"
            + "                  <mo>−</mo>"
            + "                  <mn>4</mn>"
            + "                  <mi>a</mi>"
            + "                  <mi>c</mi>"
            + "               </mrow>"
            + "            </msqrt>"
            + "         </mrow>"
            + "         <mrow>"
            + "            <mn>2</mn>"
            + "            <mi>a</mi>"
            + "         </mrow>"
            + "      </mfrac>"
            + "   </mrow>"
            + "</math>";

        String htmlBody = "<!doctype html>"
            + "<html>"
            + "   <body>"
            + "      <p>"
            + mathmlContent
            + "      </p>"
            + "   </body>"
            + "</html>";
            
        loadContent(htmlBody);

        int height = (int) executeScript(
            "elements = document.getElementsByTagName('mo');"
            + "element = elements[0].clientHeight;"
        );

        assertTrue("MathML token height must be greater than " + height, height > 1);      
    }
}
