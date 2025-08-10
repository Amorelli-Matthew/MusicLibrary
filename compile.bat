@echo off
setlocal

echo ============================================
echo Compiling MusicLibraryApplication...

cd /d "%~dp0"

:: ensure output dir
if not exist "out" mkdir "out"

:: compile (keep your fixed JavaFX path)
javac --module-path "%USERPROFILE%\Documents\javafx-sdk-24.0.1\lib" ^
      --add-modules javafx.controls,javafx.fxml ^
      -d "out" src\MusicLibraryApplication\*.java
if errorlevel 1 (
    echo ❌ Compilation failed.
    pause
    exit /b 1
)

:: copy root to out after compilation succeeds
set FILES=Collection CollectionFile CollectionFile.dat
for %%F in (%FILES%) do (
    if exist "%%~F" (
        echo Copying %%~F -> out\
        copy /Y "%%~F" "out\%%~nxF" >nul
    )
)

echo Done Compiling