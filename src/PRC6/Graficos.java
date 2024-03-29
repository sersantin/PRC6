/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRC6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Sergio
 */

public class Graficos implements ActionListener {
    
        JFreeChart graph;
        Dataset d;
        Dash das;
        
        //int i =0;

    public Graficos(Dataset d, Dash das) {
        this.d = d;
        this.das = das;
    }
        
        
        public void PieGraphF( ArrayList <Float> d,int pos, String s, String y, javax.swing.JPanel Pan, String p)
        {   
            Pan.removeAll();
            // Fuente de Datos
            DefaultPieDataset data = new DefaultPieDataset();
            int  tmp = 0;
            for(int i = pos; i <= pos+11; i++)
            {
                tmp +=1;
                data.setValue("Mes " + tmp +": "+d.get(i)+" ", d.get(i));
            }

            // Creando el Grafico
            JFreeChart chart = ChartFactory.createPieChart(
             "Gráfico de "+s+" para el año "+y+" en "+p, 
             data, 
             true, 
             true, 
             false);

            // Mostrar Grafico
            //ChartFrame frame = new ChartFrame("JFreeChart", chart);
            ChartPanel panel = new ChartPanel(chart);
            panel.setBounds(5, 5, 450, 400);
            panel.repaint();
            Pan.add(panel);
            Pan.updateUI();
            
            //frame.pack();
            //frame.setVisible(true);
            
        }
        
        public void PieGraphI( ArrayList <Integer> d,int pos, String s, String y, javax.swing.JPanel Pan,String p)
        {   
            Pan.removeAll();
             //System.out.println("Estoy EN PIEGRAPH");
            // Fuente de Datos
            DefaultPieDataset data = new DefaultPieDataset();
            int  tmp = 0;
            for(int i = pos; i <= pos+11; i++)
            {
                tmp +=1;
                data.setValue("Mes " + tmp +": "+d.get(i)+" ", d.get(i));
                                
            //data.setValue(d.get(pos), 45);
            //data.setValue("Python", 15);
            }

            // Creando el Grafico
            JFreeChart chart = ChartFactory.createPieChart(
             "Gráfico de "+s+" para el año "+y+" en "+p, 
             data, 
             true, 
             true, 
             false);

            // Mostrar Grafico
            
            ChartPanel panel = new ChartPanel(chart);
            panel.setBounds(5, 5, 450, 400);
            panel.repaint();
            Pan.add(panel);
            Pan.updateUI();
            
            
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object fuente = e.getSource();
        
        if (fuente == das.getPlace())
            JOptionPane.showMessageDialog(null, "Cambio registrado en el Sitio");
        else
            if (fuente == das.getYear())
                JOptionPane.showMessageDialog(null, "Cambio registrado en el Año");
            else
                if (fuente == das.getjComboBox1())
                    JOptionPane.showMessageDialog(null, "Cambio registrado en el Grafico");
        
        int n = Integer.parseInt(das.getYear().getSelectedItem().toString());
        int ini = das.get_pos(n);
        
        if(das.getjComboBox1().getSelectedIndex() == 0)
            das.graph.PieGraphF(das.getDataset().getTmax(),ini,das.getjComboBox1().getSelectedItem().toString(), das.getYear().getSelectedItem().toString(), das.getjPanel2(),das.getPlace().getSelectedItem().toString());
        else
            if(das.getjComboBox1().getSelectedIndex() == 1)
                das.graph.PieGraphF(das.getDataset().getTmin(),ini,das.getjComboBox1().getSelectedItem().toString(), das.getYear().getSelectedItem().toString(), das.getjPanel2(), das.getPlace().getSelectedItem().toString());
            else
                if(das.getjComboBox1().getSelectedIndex() == 2)
                    das.graph.PieGraphI(das.getDataset().getAfdays(),ini,das.getjComboBox1().getSelectedItem().toString(), das.getYear().getSelectedItem().toString(), das.getjPanel2(), das.getPlace().getSelectedItem().toString());
                else
                    if(das.getjComboBox1().getSelectedIndex() == 3)
                        das.graph.PieGraphF(das.getDataset().getRain(),ini,das.getjComboBox1().getSelectedItem().toString(), das.getYear().getSelectedItem().toString(), das.getjPanel2(), das.getPlace().getSelectedItem().toString());
                    else
                        if(das.getjComboBox1().getSelectedIndex() == 4)
                            das.graph.PieGraphF(das.getDataset().getSun(),ini,das.getjComboBox1().getSelectedItem().toString(), das.getYear().getSelectedItem().toString(), das.getjPanel2(), das.getPlace().getSelectedItem().toString());
          
    }
        
}
