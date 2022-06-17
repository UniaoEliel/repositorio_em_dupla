package pt.model.caverna;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import pt.model.ator.IAtor;

public class ControleRodada implements Comparator<IAtor>{

	@Override
	public int compare(IAtor ator1, IAtor ator2) {
		int comp = 0;
		if (ator1.getVelocidade() > ator2.getVelocidade())
			comp = 1;
		else if (ator1.getVelocidade() < ator2.getVelocidade())
			comp = -1;
		
		return comp;
	}
		
	}
	

