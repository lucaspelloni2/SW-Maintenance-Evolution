#@andreas schaufelbuehl
source("functions.R")

oracle_list<-"/Users/Andy/Desktop/UZH/software_maintenance_evolution/SW_Maintenance_Evolution/src/Exercise_1/Easy_Clinic_Data/oracle/oracle2.txt"

# Transforms the given table into a matrix, while also change file-name into a number
transFormToMatrix <- function(table, rowNumber) {
  valueVector = c()
  for(j in 1:ncol(table)) {
    for(i in 1:nrow(table)) {
      valueVector <- append(valueVector, as.numeric(gsub(".txt", "", table[i,j])))
    }
  }
  
  matrixRows <- ((length(valueVector))/rowNumber)
  M <- matrix(valueVector, nrow = matrixRows, byrow = FALSE)
  return(M)
}

#Counts up all the matches between two matrix
matchCounter <- function(matrixResult, matrixCorrect) {
  matchCounter <- 0
  for(i in 1:nrow(matrixResult)) {
    for(j in 1:nrow(matrixCorrect)) {
      if(matrixResult[i,1] == matrixCorrect[j,1] && matrixResult[i,2] == matrixCorrect[j,2]) {
        matchCounter = matchCounter + 1
      }
    }
  }
  return(matchCounter)
}






# 01. Path software artifacts - read in correct path!! 
correct_links <- read.table(file="/Users/Andy/Desktop/SW-Maintenance-Evolution/src/Exercise_1/Easy_Clinic_Data/oracle/oracle2.txt", header = FALSE, sep=",")
names(correct_links) <- c("source", "target")

#02. Read in all ranked_list - read in correct path!! 
ranked_list75<- read.table(file="/Users/Andy/Desktop/SW-Maintenance-Evolution/src/Exercise_1/Easy_Clinic_Data/rankedlists/ranked_list75.txt", header = TRUE, sep=",")
ranked_list65<- read.table(file="/Users/Andy/Desktop/SW-Maintenance-Evolution/src/Exercise_1/Easy_Clinic_Data/rankedlists/ranked_list65.txt", header = TRUE, sep=",")
ranked_list55<- read.table(file="/Users/Andy/Desktop/SW-Maintenance-Evolution/src/Exercise_1/Easy_Clinic_Data/rankedlists/ranked_list55.txt", header = TRUE, sep=",")

#03. Transform into numerical matrix
matrixCorrect <- transFormToMatrix(correct_links, 2)
matrix75 <- transFormToMatrix(ranked_list75, 3)
matrix65 <- transFormToMatrix(ranked_list65, 3)
matrix55 <- transFormToMatrix(ranked_list55, 3)

#04. Count matches with correct links
matches75 <- matchCounter(matrix75, matrixCorrect)
matches65 <- matchCounter(matrix65, matrixCorrect)
matches55 <- matchCounter(matrix55, matrixCorrect)

#05. Calculate precision & recall
prescision75 <- (matches75/nrow(matrixCorrect))
prescision65 <- (matches65/nrow(matrixCorrect))
prescision55 <- (matches55/nrow(matrixCorrect))

recall75 <- (matches75/nrow(matrix75))
recall65 <- (matches65/nrow(matrix65))
recall55 <- (matches55/nrow(matrix55))

cat("Ranked list 75:  precision=",prescision75, " recall=", recall75, "\n")
cat("Ranked list 65:  precision=",prescision65, " recall=", recall65, "\n")
cat("Ranked list 55:  precision=",prescision55, " recall=", recall55, "\n")








