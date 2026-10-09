package ar.edu.unlu.poo.cursada2026.sm.clase7.ejemplo.dibujables;

/** Contrato que debe cumplir todo objeto que pueda dibujarse y moverse. */
public interface Dibujable {
    int obtenerX();
    int obtenerY();
    Dibujo moverA(int x, int y);
    Dibujo dibujar();
    boolean estaEn(int x, int y);
}
