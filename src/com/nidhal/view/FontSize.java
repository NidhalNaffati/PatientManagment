package com.nidhal.view;

public enum FontSize {
    SMALL,
   // MEDIUM,
    BIG ;


    public static  String getCssPath(FontSize fontSize){
        switch (fontSize){

          //  case MEDIUM :
          //      return  "CSS/fontMedium.css" ;
            case BIG:
                return  "CSS/fontBig.css" ;
            case SMALL:
                return  "CSS/fontSmall.css" ;
            default:
                return null ;
        }
    }

}
