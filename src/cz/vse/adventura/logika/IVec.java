package cz.vse.adventura.logika;

public interface IVec {

    default String provedSchopnost() {
        return "Věc byla použita.";
    }
}
