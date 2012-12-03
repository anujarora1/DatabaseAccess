
#include "GlobalFunctions.h"
#include "Logger.h"

void logMessage(std::string msg) {
    Logger *myLogger= Logger::getInstance();
    myLogger->write(msg);
}
