package br.com.bernardo.carrosrest.demo.enums;


import org.apache.commons.lang3.StringUtils;

public enum CarroColor {
    //TODO: Ver quando é ordinal
    //TODO: No momento de tentar fazer alguma coisa funcionar, comemora e depois para. Pensa: Essa é a melhor forma de fazer?
    RED("Vermelho"),
    BLUE("Azul"),
    ORANGE("Laranja"),
    YELLOW("Amarelo"),
    WHITE("Branco"),
    BLACK("Preto"),
    GREEN("Verde"),
    BROWN("Marrom");

    private final String color;

    private CarroColor(String color) {
        this.color = color;
    }

    public String getColor() { return color; }

    public static CarroColor getCarroColorFromString(String color) {
        CarroColor[] carroColors = CarroColor.values();

        for (CarroColor carroColor : carroColors) {
            if(StringUtils.equals(carroColor.getColor(), color)) {
                return carroColor;
            }
        }
        return null;
    }
}
