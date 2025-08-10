echo Running MusicLibraryApplication...
cd out
java --module-path "%USERPROFILE%\Documents\javafx-sdk-24.0.1\lib" ^
     --add-modules javafx.controls,javafx.fxml ^
     -cp . MusicLibraryApplication.MusicLibraryApplication

echo.
echo Done!
pause