package org.example;

import org.example.controller.MainMenuController;
import org.example.repo.AlbumRepo;
import org.example.repo.ArtistRepo;
import org.example.repo.factory.AlbumRepoFactory;
import org.example.repo.factory.ArtistRepoFactory;
import org.example.view.ConsoleIO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConsoleIO io = new ConsoleIO();
        AlbumRepo albums = AlbumRepoFactory.instance();
        ArtistRepo artists = ArtistRepoFactory.instance();
        // UserRepo users = UserRepoFactory.instance();
        // Config appConfig = new Config(albums, artists);

        // AppView appView = new AppView(io);
        MainMenuController mainMenu = new MainMenuController(io, albums, artists);
        // MainMenuController mainMenu = new MainMenuController(config, appView);
        mainMenu.run();



    }
}
