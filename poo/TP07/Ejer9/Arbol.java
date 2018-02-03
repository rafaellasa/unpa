package Ejer9;

public class Arbol {

	     private Nodo raiz;
	     
	     
public Arbol()
		 {
	      raiz=null;
		 }
 
public	void insertar (int valor)
		 {
		 Nodo Nuevo, P, Ant;
		 Nuevo = new Nodo(valor); 
		 P = raiz;
		 Ant = null;
		 while(P!=null)
		 	 {
		   	 Ant = P;
		   	 if (P.getInfo() > valor)
		   		 P = P.getIzquierda(); 
		   	 else P = P.getDerecha(); 
		 	 }
		 	if ( Ant == null) 
		 		raiz = Nuevo;
		 	else
		 		if (Ant.getInfo() > valor)
		 			Ant.setIzquierda(Nuevo); 
		 		else Ant.setDerecha(Nuevo);
		 }		 





public boolean busqueda(Nodo n,int valor, boolean enc)
			{
		     if(n==null |enc==true)
		    	 return enc;
		     else
		       {
		    	 if(n.getInfo()==valor)
		    		 return true;
		    	 else
		    		 if(n.getInfo() < valor)
		    			 n=n.getDerecha();
		    		 else n=n.getIzquierda();
		    	 return busqueda(n,valor,enc);
		       }
			}
//no funciona hecho en clase, siempre no encontrado
public boolean buscarRecursivo(int valor, Nodo p, boolean enc)
		{
		 if(p!=null && !enc)
		   {
			 if(p.getInfo()!= valor)
				 if(valor>p.getInfo())
					 buscarRecursivo(valor,p.getDerecha(), enc);
				 else
					 buscarRecursivo(valor,p.getIzquierda(), enc);
			 else
				 enc=true;
		   }
		 else
		    {
			 enc=false;
		    }
		 return enc;
		}
	

public boolean estaVacio()
		{
	     return (raiz==null);
	    }


public Nodo getRaiz()
		{
		 return raiz;
		} 


public void eliminar(int valor)
		 {
		  Nodo p = raiz;
		  Nodo t = null;
		  while(p.getInfo() != valor ) 
		      {
			  t = p;
			  if ( valor > p.getInfo() )
				  p = p.getDerecha();
			  else
				  p = p.getIzquierda();
		      }
		  if ( p.esHoja() )
			  if ( t == null ) raiz = null; 
			  else if ( p == t.getIzquierda() )
				  t.setIzquierda(null);
			  else t.setDerecha(null); 
		  else if (p.tieneUnHijo()) 
			  if (t.getIzquierda() == p)
				  t.setIzquierda(p.getUnicoHijo());
			  else
				  t.setDerecha(p.getUnicoHijo()); 
		  else 
		  {
			  Nodo q = buscaMenor(p);
			  p.setInfo(q.getInfo());
			  t = p; 
			  p = p.getIzquierda();
			  while (p != q)
			      {
				  t = p;
				  p = p.getDerecha(); 
			      }
			  if (q==t.getIzquierda())
				  t.setIzquierda(q.getIzquierda()); 
			  else	
				  if (q.tieneUnHijo())
					  t.setDerecha(q.getUnicoHijo());
				  else
					  t.setDerecha(null); 
		  	}
		 }
	


public Nodo buscaMenor(Nodo p) 
		 {
		  Nodo aux = p.getIzquierda(); 
		  while ( aux.getDerecha() != null)
			  aux = aux.getDerecha(); 
		  return aux;
		 }

public void inorden ( Nodo P)
			{
    		if(P != null)                      
    		  {                                
              inorden (P.getIzquierda());
              System.out.print("|"+P.getInfo()+"|");
              inorden (P.getDerecha());
    		  }
			}

public void preorden ( Nodo P)
		   {
    	   if(P != null)                       
           	 {                                
              System.out.print("|"+P.getInfo()+"|");
              preorden (P.getIzquierda());
              preorden (P.getDerecha());
            }
		   }



public void postorden ( Nodo P)
		   {
    		if(P != null)                       
    		  {                               
               postorden (P.getIzquierda());
               postorden (P.getDerecha());
               System.out.print("|"+P.getInfo()+"|");
    		  }
		   }




	
	
}
