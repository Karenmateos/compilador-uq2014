package interfaz;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class PanelAnalizadorSintactico extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTree arbolVisual;
	private JScrollPane scrollArbolVisual;

	public PanelAnalizadorSintactico(int x, int y) 
	{
		try {
			{
				scrollArbolVisual = new JScrollPane();
				this.add(scrollArbolVisual);
				scrollArbolVisual.setPreferredSize(new java.awt.Dimension(x, y));

				{
					arbolVisual = new JTree(new DefaultTreeModel(new DefaultMutableTreeNode("Arbol Visual...")));
					scrollArbolVisual.setViewportView(arbolVisual);

				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public JTree getArbolVisual() {
		return arbolVisual;
	}

	public void setArbolVisual(JTree arbolVisual) {
		this.arbolVisual = arbolVisual;
	}

}