# qpy:kivy
# Kivy Imports
import gc

from kivy.app import App
from kivy.uix.anchorlayout import AnchorLayout
from kivy.uix.floatlayout import FloatLayout
from kivy.uix.screenmanager import NoTransition
from kivy.uix.screenmanager import ScreenManager
from kivymd.theming import ThemeManager

from ui.screens.TicTacScreen import TicTacScreen
from ui.screens.Battleship_screen import BattleshipScreen
from ui.screens.Paintball import PaintBallScreen
from ui.screens.Ships import ShipScreen
from ui.screens.Snakes import SnakeScreen

# Project imports
from ui.screens.welcome_screen import WelcomeScreen
from util.utility import Utility

gc.disable()


class MainBox(FloatLayout):
    def __init__(self, **kwargs):
        super(MainBox, self).__init__()
        self.screens = AnchorLayout(anchor_x='center', anchor_y='center')
        self.util = kwargs.get('util')
        self.content = ScreenManager()
        self.content.transition = NoTransition()

        # Place screens here
        self.content.add_widget(WelcomeScreen(name='welcome', util=self.util))
        self.content.add_widget(BattleshipScreen(name='battleship', util=self.util))
        self.content.add_widget(TicTacScreen(name='tic', util=self.util))
        self.content.add_widget(PaintBallScreen(name='paintball', util=self.util))
        self.content.add_widget(ShipScreen(name='ships', util=self.util))
        self.content.add_widget(SnakeScreen(name='snakes', util=self.util))
        # self.content.add_widget(TrainingMenuScreen(name='training', util=self.util))
        # self.content.add_widget(ListeningScreen(name='listening', util=self.util))
        # self.content.add_widget(TappingScreen(name='tapping', util=self.util))
        # self.content.add_widget(CalibrationScreen(name='calibration', util=self.util))
        # self.content.add_widget(SignInScreen(name='sign_in', util=self.util))
        # self.content.add_widget(AddContactScreen(name='add_contact', util=self.util))
        # self.content.add_widget(MessageScreen(name='message', util=self.util))
        # # Place screens here

        self.screens.add_widget(self.content)

        self.add_widget(self.screens)


class MainApp(App):
    util = Utility()
    # Change APP colors here
    theme_cls = ThemeManager()
    theme_cls.primary_palette = 'Teal'
    theme_cls.primary_hue = '300'
    theme_cls.accent_palette = 'Gray'
    theme_cls.accent_hue = '800'
    theme_cls.theme_style = 'Dark'
    accent_color = [255/255, 64/255, 129/255, 1]

    def build(self):
        return MainBox(util=self.util)


if __name__ == "__main__":
    MainApp().run()
