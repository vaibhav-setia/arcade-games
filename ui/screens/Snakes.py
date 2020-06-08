# Kivy imports
from kivy.uix.screenmanager import Screen
from kivy.uix.anchorlayout import AnchorLayout
from kivy.app import App
from kivy.metrics import dp
from kivy.utils import platform

from kivymd.uix.button import MDFloatingActionButton
from kivymd.uix.card import MDCard
from kivymd.uix.label import MDLabel

from ui.widgets.nav_drawer import MyNavigationLayout
import os

class SnakeScreen(Screen):
    def __init__(self, **kwargs):
        super(SnakeScreen, self).__init__(name=kwargs.get('name'))

        self.ui_layout()

    def ui_layout(self):

        start_game_button_anchor = AnchorLayout(anchor_x='center', anchor_y='bottom',
                                                padding=[dp(25), dp(25), dp(25), dp(25)])


        self.start_game_button = MDFloatingActionButton(icon='play', size=[dp(56), dp(56)])
        self.start_game_button.md_bg_color = App.get_running_app().theme_cls.primary_color
        self.start_game_button.text_color = [1, 1, 1, 1]

        if platform not in ['ios', 'android']:
            self.start_game_button.bind(on_press=lambda x: self.start_game())


        start_game_button_anchor.add_widget(self.start_game_button)


        game_card = MDCard(padding=dp(24), spacing=dp(24), orientation='vertical',
                           size_hint_x=0.85, size_hint_y=0.7,
                           pos_hint={'top': 0.85, 'center_x': 0.5})
        rules = """Snakes and ladders is a game to play with your friends. Navigate your piece from start to finish, avoid the snakes, and take shortcuts going up the ladders.


How to play:

Each player starts from base. Both players alternatively roll the dice and move the respective pawns.
If your pawn lands at the bottom of a ladder, you can move up to the top of the ladder.
If your pawn lands on the head of a snake, you must slide down to the bottom of the snake.
The first player to get to the last tile numbered '100'  is the winner."""
        game_label = MDLabel(text=rules, font_style='Body1', halign='center',
                             size_hint=(1, 0.5))
        game_label.theme_text_color = 'Custom'
        game_label.text_color = [1, 1, 1, 1]
        game_card.add_widget(game_label)
        game_card.md_bg_color = App.get_running_app().theme_cls.accent_color
        game_card.elevation = 15

        self.add_widget(game_card)
        self.add_widget(start_game_button_anchor)

        # Nav Bar
        self.nav_bar = MyNavigationLayout()
        self.nav_bar_anchor = AnchorLayout(anchor_x='center', anchor_y='top')
        self.nav_bar_anchor.add_widget(self.nav_bar)
        self.add_widget(self.nav_bar_anchor)


    def start_game(self):

        # add this line - os.system('java -jar ./jar/<filename>.jar')
        os.system('java -jar ./jar/SNAKES_AND_LADDERS.jar')

    def return_home(self):
        self.manager.current = 'welcome'
