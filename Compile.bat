@echo off
setlocal enabledelayedexpansion

echo ============================================
echo Compiling MusicLibraryApplication...

cd /d "%~dp0"

:: Ensure output dir
if not exist "out" mkdir "out"

:: Set the specific path to JavaFX lib folder
:: Using quotes is vital because "Program Files (x86)" contains spaces
set "FX_LIB=C:\Program Files (x86)\javafx\javafx-sdk\lib"

:: Verify the path exists before trying to compile
if not exist "%FX_LIB%" (
    echo [ERROR] JavaFX library not found at: "%FX_LIB%"
    pause
    exit /b 1
)

:: Compile
javac --module-path "%FX_LIB%" ^
      --add-modules javafx.controls,javafx.fxml ^
      -d "out" src\MusicLibraryApplication\*.java

if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
)

:: Copy data files
set FILES=Collection CollectionFile CollectionFile.dat
for %%F in (%FILES%) do (
    if exist "%%~F" (
        echo Copying %%~F -^> out\
        copy /Y "%%~F" "out\%%~nxF" >nul
    )
)

echo Done Compiling.
pause