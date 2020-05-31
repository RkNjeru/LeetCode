class FlowerSolution{

    public boolean canPlaceFlowers(int[] flowerbed, int n){
        int bedIndex = 0;
        int bedMaxInd = flowerbed.length;

        if(flowerbed.length == 1 && flowerbed[0] == 0){
            return true;
        }
        
        while(bedIndex < bedMaxInd && n != 0){
            if(flowerbed[bedIndex] == 1){
                if(bedIndex + 2 < bedMaxInd){
                    if(bedIndex + 3 < bedMaxInd){
                        if(flowerbed[bedIndex + 1] == 0 && flowerbed[bedIndex + 2] == 0 && flowerbed[bedIndex + 3] == 0){
                            flowerbed[bedIndex + 2] = 1;
                            n--;
                            bedIndex += 4;
                            continue;
                        }
                        else{
                            bedIndex++;
                        }
                    }
                    else{
                        if(flowerbed[bedIndex + 1] == 0 && flowerbed[bedIndex + 2] == 0 && bedIndex + 3 == bedMaxInd){
                            flowerbed[bedIndex + 2] = 1;
                            n--;
                            break;
                        }
                        else{
                            bedIndex++;
                        }
                    }
                }
                else{
                    break;
                }
            }
            else if(flowerbed[bedIndex] == 0){
                if(bedIndex + 1 < bedMaxInd && bedIndex - 1 >= 0){
                    if(flowerbed[bedIndex - 1] == 0 && flowerbed[bedIndex + 1] == 0){
                        flowerbed[bedIndex] = 1;
                        n--; 
                        bedIndex += 2;
                        continue;
                    }
                    else{
                        bedIndex++;
                    }
                }
                else if(bedIndex + 1 < bedMaxInd && bedIndex == 0){
                    if(flowerbed[bedIndex + 1] == 0){
                        flowerbed[bedIndex] = 1;
                        n--;
                        bedIndex += 2;
                        continue;
                    }
                    else{
                        bedIndex++;
                    }
                }
                else if(bedIndex + 1 == bedMaxInd && flowerbed[bedIndex - 1] == 0){
                    flowerbed[bedIndex] = 1;
                    n--;
                    break;
                }
                else{
                    bedIndex++;
                }
            }
        }

        return n == 0;
    }

    public static void main(String[] args){
        FlowerSolution classObj = new FlowerSolution();
        int[] aBed = {1, 0, 0, 0, 0};
        int aN = 2;
        System.out.println(classObj.canPlaceFlowers(aBed, aN));
    }
}