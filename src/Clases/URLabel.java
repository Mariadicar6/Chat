package Clases;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JLabel;

public class URLabel extends JLabel implements MouseListener {

    private URI url;

    public URLabel(){        
        //enlace por default
        try {
            url = new URI("http://www.google.com.");
        } catch (URISyntaxException ex) {}
        //propiedades de JLabel
        this.setText("URLabel");
        this.setToolTipText( url.toString() );
        this.setSize(34, 18);
        this.setVisible(true);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseListener(this);

    }


    public void setURL( String url )
    {
        try {
            this.url = new URI(url);
            this.setToolTipText( url );
        } catch (URISyntaxException ex) {
            System.err.println( ex.getMessage() );
        }
    }


    public String getURL()
    {
        return this.url.toString();
    }

   @Override
   protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Rectangle r;            
        r = g.getClipBounds();            
        g.drawLine(0, r.height - getFontMetrics(getFont()).getDescent(), getFontMetrics(getFont())
                .stringWidth(getText()), r.height - getFontMetrics(getFont()).getDescent());        
  }


    @Override
    public void mouseClicked(MouseEvent e) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if ( desktop != null && desktop.isSupported(Desktop.Action.BROWSE) ) {
            try {
                desktop.browse( url );
            } catch ( IOException ex ) {
                System.err.println( ex.getMessage() );
            }
        }    
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}    

}//--> fin clase