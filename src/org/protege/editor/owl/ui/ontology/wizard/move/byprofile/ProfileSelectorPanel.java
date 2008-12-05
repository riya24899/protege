package org.protege.editor.owl.ui.ontology.wizard.move.byprofile;

import org.protege.editor.owl.ui.ontology.wizard.move.MoveAxiomsKitConfigurationPanel;
import org.semanticweb.owl.profiles.ELPlusPlusProfile;
import org.semanticweb.owl.profiles.OWL2Profile;
import org.semanticweb.owl.profiles.OWLDLProfile;
import org.semanticweb.owl.profiles.OWLProfile;

import javax.swing.*;
/*
* Copyright (C) 2007, University of Manchester
*
* Modifications to the initial code base are copyright of their
* respective authors, or their employers as appropriate.  Authorship
* of the modifications may be determined from the ChangeLog placed at
* the end of this file.
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.

* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.

* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/

/**
 * Author: drummond<br>
 * http://www.cs.man.ac.uk/~drummond/<br><br>
 * <p/>
 * The University Of Manchester<br>
 * Bio Health Informatics Group<br>
 * Date: Dec 3, 2008<br><br>
 */
public class ProfileSelectorPanel extends MoveAxiomsKitConfigurationPanel {

    private MoveAxiomsByProfileKit kit;

    private JRadioButton owlDLButton;

    private JRadioButton elPPButton;

    private JRadioButton owl2Button;


    public ProfileSelectorPanel(MoveAxiomsByProfileKit kit) {
        this.kit = kit;
    }


    public void initialise() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(owlDLButton = new JRadioButton("OWL DL", true));
        add(owl2Button = new JRadioButton("OWL 2"));
        add(elPPButton = new JRadioButton("EL++"));

        ButtonGroup bg = new ButtonGroup();
        bg.add(owl2Button);
        bg.add(owlDLButton);
        bg.add(elPPButton);
    }


    public void dispose() {
        // do nothing
    }


    public String getID() {
        return getClass().getName();
    }


    public String getTitle() {
        return "Select profile";
    }


    public String getInstructions() {
        return "Select the OWL profile that you wish to extract.";
    }


    public void update() {
        // do nothing
    }


    public void commit() {
        kit.setProfile(getSelectedProfile());
    }


    private OWLProfile getSelectedProfile() {
        if (owl2Button.isSelected()){
            return new OWL2Profile();
        }
        else if (owlDLButton.isSelected()){
            return new OWLDLProfile();
        }
        else if (elPPButton.isSelected()){
            return new ELPlusPlusProfile();
        }
        return null;
    }
}
