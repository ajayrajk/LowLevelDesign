package org.designpattern.creational.builder.withbuilder;



public class House {

    private String foundation;
    private String walls;
    private String roof;
    private boolean swimmingPool;
    private boolean garden;
    private boolean garage;

    private House(HouseBuilder houseBuilder) {
               this.foundation=houseBuilder.foundation;
               this.walls=houseBuilder.walls;
               this.roof=houseBuilder.roof;
               this.swimmingPool=houseBuilder.swimmingPool;
               this.garden=houseBuilder.garden;
               this.garage=houseBuilder.garage;
    }

    public static class HouseBuilder{
        private String foundation;
        private String walls;
        private String roof;
        private boolean swimmingPool;
        private boolean garden;
        private boolean garage;

        public HouseBuilder foundation(String foundation){
            this.foundation=foundation;
            return this;
        }

        public  HouseBuilder walls(String walls){
            this.walls=walls;
            return this;
        }

        public HouseBuilder roof(String roof){
            this.roof=roof;
            return this;
        }

        public HouseBuilder swimmingPool(boolean swimmingPool){
            this.swimmingPool=swimmingPool;
            return this;
        }

        public HouseBuilder garden(boolean garden){
            this.garden=garden;
            return this;
        }

        public HouseBuilder garage(boolean garage){
            this.garage=garage;
            return this;
        }

        @Override
        public String toString() {
            return "HouseBuilder{" +
                    "foundation='" + foundation + '\'' +
                    ", walls='" + walls + '\'' +
                    ", roof='" + roof + '\'' +
                    ", swimmingPool=" + swimmingPool +
                    ", garden=" + garden +
                    ", garage=" + garage +
                    '}';
        }

        public House build(){
            return  new House(this);
        }



    }




}
