package tech.ada.locadoraveiculos.exception;

public class VeiculoNotFoundException extends RuntimeException {

    public VeiculoNotFoundException(String message) {
        super(message);
    }
}