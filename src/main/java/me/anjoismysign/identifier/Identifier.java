package me.anjoismysign.identifier;

import me.anjoismysign.anjo.swing.components.AnjoComboBox;
import me.anjoismysign.anjo.swing.components.AnjoTextField;
import me.anjoismysign.anjo.swing.listeners.TextInputType;
import me.anjoismysign.hahaswing.BubbleFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.Objects;
import java.util.UUID;

public class Identifier {
    public static void main(String[] args) {
        open();
    }

    private static void open() {
        BubbleFactory.getInstance().controller(anjoPane -> System.exit(0),
                        "HahaIdentifier",
                        new ImageIcon(Objects.requireNonNull(Identifier.class.getResource("/anjoismysignature.png")))
                                .getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH),
                        true,
                        null)
                .onBlow(anjoPane -> {
                    if (anjoPane.didCancel())
                        return;
                    UUID random = UUID.randomUUID();
                    StringSelection stringSelection = new StringSelection(random.toString());
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                    JOptionPane.showMessageDialog(null, "Copied to clipboard: "+random);
                    open();
                });
    }
}