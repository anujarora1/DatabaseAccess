
#include <fstream>
#include <string>

#include "Logger.h"

Logger* Logger::instance = NULL;

Logger* Logger::getInstance() {

    if (NULL == instance)
        instance = new Logger();
    
    return instance;
}

Logger::Logger() {
    loggerStream.open("run.log");
}

Logger::~Logger() {
    loggerStream.flush();
    loggerStream.close();
}

Logger::Logger(const Logger &theLogger) {
}

void Logger::write (std::string &msg) {
    loggerStream << msg << '\n';
}
