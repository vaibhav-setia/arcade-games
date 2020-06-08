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

class TicTacScreen(Screen):
    def __init__(self, **kwargs):
        super(TicTacScreen, self).__init__(name=kwargs.get('name'))

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
        rules = """You probably already know how to play Tic-Tac-Toe. It's a really simple game, right? That's what most people think. But if you really wrap your brain around it, you'll discover that Tic-Tac-Toe isn't quite as simple as you think!
        
        1. The game is played on a grid that's 3 squares by 3 squares.

        2. You are X, your friend (or the computer in this case) is O. Players take turns putting their marks in empty squares.

        3. The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.

        4. When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie."""
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
        os.system('java -jar ./jar/TICTACTOE.jar')

    def return_home(self):
        self.manager.current = 'welcome'
